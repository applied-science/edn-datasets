(ns applied-science.edn-datasets
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]))


(def ^{:doc "Waiting time between eruptions and the duration of the eruption for the Old Faithful geyser in Yellowstone National Park, Wyoming, USA."
        :format "Sequence of maps containing 272 observations on 2 variables."
        :source "Härdle, W. (1991). Smoothing Techniques with Implementation in S. New York: Springer."
        :references ["Azzalini, A. and Bowman, A. W. (1990). A look at some data on the Old Faithful geyser. Applied Statistics, 39, 357–365. doi: 10.2307/2347385."
                     "https://stat.ethz.ch/R-manual/R-devel/library/datasets/html/faithful.html"]}
  old-faithful
  (edn/read-string (slurp (io/resource "old-faithful.edn"))))


(def ^{:doc "The famous (Fisher's or Anderson's) iris data set: measurements (in centimeters) of flowers' sepal length and width and petal length and width, respectively, for 50 flowers from each of 3 species of iris."
       :format "Sequence of maps containing 150 samples: 50 observations on 4 variables, for 3 species"
       :source "Fisher, R. A. (1936) The use of multiple measurements in taxonomic problems. Annals of Eugenics, 7, Part II, 179–188. The data were collected by Anderson, Edgar (1935). The irises of the Gaspe Peninsula, Bulletin of the American Iris Society, 59, 2–5."}
  iris
  (edn/read-string (slurp (io/resource "iris.edn"))))
