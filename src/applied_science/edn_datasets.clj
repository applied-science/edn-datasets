(ns applied-science.edn-datasets
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]))


(def ^{:doc "Waiting time between eruptions and the duration of the eruption for the Old Faithful geyser in Yellowstone National Park, Wyoming, USA."
        :format "272 observations on 2 variables."
        :source "Härdle, W. (1991). Smoothing Techniques with Implementation in S. New York: Springer."
        :references ["Azzalini, A. and Bowman, A. W. (1990). A look at some data on the Old Faithful geyser. Applied Statistics, 39, 357–365. doi: 10.2307/2347385."
                     "https://stat.ethz.ch/R-manual/R-devel/library/datasets/html/faithful.html"]}
  old-faithful
  (edn/read-string (slurp (io/resource "old-faithful.edn"))))
