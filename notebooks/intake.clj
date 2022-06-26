(ns intake
  (:require [clojure.string :as string]
            [jsonista.core :as json]
            [meta-csv.core :as mcsv]
            [nextjournal.clerk :as clerk]))

(comment ;;;; `old-faithful`
  (spit "resources/old-faithful.edn"
        (into [] (mcsv/read-csv "data/raw/old-faithful.csv")))

  )
