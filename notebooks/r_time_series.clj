^{:nextjournal.clerk/visibility :hide-ns}
(ns notebooks.r-time-series
  "Acquiring and exploring some of R's built-in time series datasets"
  (:require [appliedsciencestudio.rdata :refer [read-rdata]]
            [clojure.set :refer [rename-keys]]))

;; # Acquiring and exploring some of R's built-in time series datasets

;; See mtcars notebook for steps to export these from R

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

(spit "resources/lake-huron.edn"
      (mapv #(hash-map :level (int %1), :year %2)
            (get (read-rdata "data/raw/LakeHuron.rdata") "LakeHuron")
            (range 1875 1973)))


;; ## R's [`uspop`](https://search.r-project.org/R/refmans/datasets/html/uspop.html) dataset

(spit "resources/us-pop.edn"
      (mapv #(hash-map :n %1, :year %2)
            (get (read-rdata "data/raw/uspop.rdata") "uspop")
            (range 1790 1971 10)))
