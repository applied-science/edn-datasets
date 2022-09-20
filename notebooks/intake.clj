(ns notebooks.intake
  (:require [clojure.string :as string]
            [jsonista.core :as json]
            [meta-csv.core :as mcsv]
            [nextjournal.clerk :as clerk]
            [appliedsciencestudio.rdata :refer [read-rdata]]))

(comment ;;; `old-faithful`
  (spit "resources/old-faithful.edn"
        (into [] (mcsv/read-csv "data/raw/old-faithful.csv"
                                {:fields [:eruption :waiting]})))

  )


(comment ;;; `iris`
  (spit "resources/iris.edn"
        (into [] (mcsv/read-csv "data/raw/iris.csv"
                                {:fields [:sepal-length :sepal-width
                                          :petal-length :petal-width
                                          :species]})))

  )
