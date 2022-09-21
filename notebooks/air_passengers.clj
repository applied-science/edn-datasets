^{:nextjournal.clerk/visibility :hide-ns}
(ns notebooks.air-passengers
  "Acquiring and exploring R's built-in AirPassengers dataset"
  (:require [appliedsciencestudio.rdata :refer [read-rdata]]
            [clojure.set :refer [rename-keys]]))

;; # R's [`AirPassengers`](https://search.r-project.org/R/refmans/datasets/html/AirPassengers.html) dataset

;; See mtcars notebook for steps to export from R

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
