(ns notebooks.intake
  (:require #_[jsonista.core :as json]
            [applied-science.edn-datasets :as edn-datasets]
            [meta-csv.core :as mcsv]))

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


(comment ;;; `anscombe`
  (spit "resources/anscombe.edn"
        edn-datasets/anscombe)

  )
