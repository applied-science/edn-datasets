^{:nextjournal.clerk/visibility :hide-ns}
(ns notebooks.mtcars
  "Acquiring and exploring R's built-in mtcars dataset"
  (:require [appliedsciencestudio.rdata :refer [read-rdata]]
            [clojure.set :refer [rename-keys]]))

;; # R's [`mtcars`](https://search.r-project.org/R/refmans/datasets/html/mtcars.html) dataset

;; R comes with a bunch of handy small datasets built-in. Let's use one as an
;; example of acquiring data.

;; Normally I'd just grab this dataset as CSV from the web, but I'd like to take
;; this opportunity to show off the possibility of reading datasets found as
;; rdata files – directly from Clojure. We are, after all, on the JVM.

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
