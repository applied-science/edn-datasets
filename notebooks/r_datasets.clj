^{:nextjournal.clerk/visibility :hide-ns}
(ns notebooks.r-datasets
  "Acquiring and exploring some of R's built-in datasets"
  (:require [appliedsciencestudio.rdata :refer [read-rdata]]
            [clojure.set :refer [rename-keys]]))

;; # Acquiring and exploring some of R's built-in datasets

;; R comes with a bunch of handy small datasets built-in. Let's use one as an
;; example of acquiring data.


;; ## R's [`mtcars`](https://search.r-project.org/R/refmans/datasets/html/mtcars.html) dataset

;; In the normal course of work I might just grab this dataset as CSV from the
;; web, but I'd like to take this opportunity to show off the possibility of
;; reading datasets found as rdata files – directly from Clojure. We are, after
;; all, on the JVM.

;; I install R & RStudio. In RStudio:
;;
;;    install.packages("knitr") # purely to see graphical output
;;    ?mtcars # pretty docs
;;    mtcars # always a good idea to look at the data
;;    save(mtcars,file="path/to/edn-datasets/data/raw/mtcars.rdata",version=2) # NB: without the optional `version` parameter, Renjin (and thus rdata) will not be able to read it

;; Now:

(def mtcars-raw
  (read-rdata "data/raw/mtcars.rdata"))

(spit "resources/mtcars.edn" mtcars-raw)

;; That provides the necessary EDN for our API.

;; We might instead want a seq of maps:
(mapv zipmap
      (repeat (keys mtcars-raw))
      (apply map vector (vals mtcars-raw)))


;; One might reasonably want nicer names for keys, and to de-code values.
(let [mtcars' (-> mtcars-raw
                  (update "am" #(map {0.0 :auto, 1.0 :manual} %))
                  (update "vs" #(map {0.0 :v-shaped, 1.0 :straight} %))
                  (rename-keys {"am"    :transmission
                                "carb"  :carburetors
                                "cyl"   :cylinders
                                "disp"  :displacement      ;; (cubic inches)
                                "drat"  :rear-axle-ratio
                                "gear"  :gears
                                "hp"    :horsepower        ;; (gross)
                                "mpg"   :mpg               ;; (US gallons)
                                "qsec"  :time-quarter-mile ;; (seconds)
                                "vs"    :engine            ;; see note in metadata
                                "wt"    :weight            ;; (1000 lbs)
                                }))]
  (mapv zipmap
        (repeat (map keyword (keys mtcars')))
        (apply map vector (vals mtcars'))))

;; This result has some vague similarities to `mtcars2` from `mtcars`'s docs.

;; TODO mimic R's docs by plotting mpg against displacement (DAL: also weight?), grouped (with color or parallel plots) by # cylinders


;; ## R's [`AirPassengers`](https://search.r-project.org/R/refmans/datasets/html/AirPassengers.html) dataset

(def air-passengers-raw
  (read-rdata "data/raw/AirPassengers.rdata"))

;; It weirds me out that it's completely unlabeled. In R it's a time series
;; object, and thus injects additional data when printing and so on. Let's
;; restore some of that before writing to EDN.

(spit "resources/air-passengers.edn"
      (mapv #(hash-map :n (int %1), :month %2, :year %3)
            (get air-passengers-raw "AirPassengers")
            (cycle (range 1 13))
            (mapcat (partial repeat 12) (range 1949 1961))))


;; ## R's [`LakeHuron`](https://search.r-project.org/R/refmans/datasets/html/LakeHuron.html) dataset

;; Also a time series
(spit "resources/lake-huron.edn"
      (mapv #(hash-map :level (int %1), :year %2)
            (get (read-rdata "data/raw/LakeHuron.rdata") "LakeHuron")
            (range 1875 1973)))


;; ## R's [`uspop`](https://search.r-project.org/R/refmans/datasets/html/uspop.html) dataset

;; Also a time series
(spit "resources/us-pop.edn"
      (mapv #(hash-map :n %1, :year %2)
            (get (read-rdata "data/raw/uspop.rdata") "uspop")
            (range 1790 1971 10)))


;; ## R's [`quakes`](https://search.r-project.org/R/refmans/datasets/html/quakes.html) dataset

;; Not a time series! We can re-use the logic we used for `mtcars`.
(let [data (get (read-rdata "data/raw/quakes.rdata") "quakes")]
  (mapv zipmap
        (repeat (map keyword (keys data)))
        (apply map vector (vals data))))

;; That seems worth concretizing:

(defn rdata-map->mapseq
  "'Reshapes' given RData nested map into a seq of maps.
  Only works at a single level of nesting, so you often need to pass it the result of a 'get'. Keywordizes keys."
  [data]
  (mapv zipmap
        (repeat (map keyword (keys data)))
        (apply map vector (vals data))))

(spit "resources/quakes.edn"
      (rdata-map->mapseq (get (read-rdata "data/raw/quakes.rdata") "quakes")))



