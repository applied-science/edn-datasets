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



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; R datasets

(comment ;;; `mtcars`
  ;; See https://search.r-project.org/R/refmans/datasets/html/mtcars.html

  ;; Normally I'd just grab a CSV but I'd like to take this opportunity to show
  ;; off the possibility of reading datasets found as rdata files directly from
  ;; Clojure.

  ;; I install R & RStudio. In RStudio:
  ;;
  ;;     install.packages("knitr") # purely to see graphical output
  ;;     ?mtcars
  ;;     mtcars # always a good idea to look at the data
  ;;     save(mtcars,file="path/to/edn-datasets/data/raw/mtcars.rdata",version=2) # NB: without the optional `version` parameter, Renjin (and thus rdata) will not be able to read it

  (def mtcars-raw
    (read-rdata "data/raw/mtcars.rdata"))

  (spit "resources/mtcars.edn" mtcars-raw)

  )
