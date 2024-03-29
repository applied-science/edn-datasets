(ns applied-science.edn-datasets
  "Datasets in EDN (extensible data notation)"
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


(def ^{:doc "Anscombe's Quartet: Four x-y datasets which have the same traditional statistical properties (mean, variance, correlation, regression line, etc.), yet are quite different."
       :format "Sequence of maps containing 11 observations on 8 variables"
       :source "Tufte, Edward R. (1989). The Visual Display of Quantitative Information, 13–14. Graphics Press."
       :references ["Anscombe, Francis J. (1973). Graphs in statistical analysis. The American Statistician, 27, 17–21. doi: 10.2307/2682899."]}
  anscombe
  [{:x1 10 :x2 10 :x3 10 :x4  8 :y1  8.04 :y2 9.14 :y3  7.46 :y4  6.58}
   {:x1 8  :x2  8 :x3  8 :x4  8 :y1  6.95 :y2 8.14 :y3  6.77 :y4  5.76}
   {:x1 13 :x2 13 :x3 13 :x4  8 :y1  7.58 :y2 8.74 :y3 12.74 :y4  7.71}
   {:x1 9  :x2  9 :x3  9 :x4  8 :y1  8.81 :y2 8.77 :y3  7.11 :y4  8.84}
   {:x1 11 :x2 11 :x3 11 :x4  8 :y1  8.33 :y2 9.26 :y3  7.81 :y4  8.47}
   {:x1 14 :x2 14 :x3 14 :x4  8 :y1  9.96 :y2 8.10 :y3  8.84 :y4  7.04}
   {:x1 6  :x2  6 :x3  6 :x4  8 :y1  7.24 :y2 6.13 :y3  6.08 :y4  5.25}
   {:x1 4  :x2  4 :x3  4 :x4 19 :y1  4.26 :y2 3.10 :y3  5.39 :y4 12.50}
   {:x1 12 :x2 12 :x3 12 :x4  8 :y1 10.84 :y2 9.13 :y3  8.15 :y4  5.56}
   {:x1 7  :x2  7 :x3  7 :x4  8 :y1  4.82 :y2 7.26 :y3  6.42 :y4  7.91}
   {:x1 5  :x2  5 :x3  5 :x4  8 :y1  5.68 :y2 4.74 :y3  5.73 :y4  6.89}])


(def  ^{:doc "The Datasaurus Dozen: thirteen (!) artificial datasets with the same summary statistics (x/y mean, x/y standard deviation, and Pearson's correlation) to two decimal places."
       :format "A seq of maps with x & y values, plus a dataset identifier"
        :sources ["Justin Matejka, George Fitzmaurice, 'Same Stats, Different Graphs: Generating Datasets with Varied Appearance and Identical Statistics through Simulated Annealing', https://www.autodesk.com/research/publications/same-stats-different-graphs"
                  "Alberto Cairo, 'Download the Datasaurus: Never trust summary statistics alone; always visualize your data', http://www.thefunctionalart.com/2016/08/download-datasaurus-never-trust-summary.html"]}
  datasaurus-dozen
  (edn/read-string (slurp (io/resource "datasaurus-dozen.edn"))))


(def ^{:doc "The classic Box & Jenkins airline data. Monthly totals of international airline passengers, 1949 to 1960. From R's built-in dataset; see https://search.r-project.org/R/refmans/datasets/html/AirPassengers.html"
       :format "A sequence of maps describing a monthly time series, with `n` in thousands."
       :source "Box, G. E. P., Jenkins, G. M. and Reinsel, G. C. (1976) Time Series Analysis, Forecasting and Control. Third Edition. Holden-Day. Series G."}
  air-passengers
  (edn/read-string (slurp (io/resource "air-passengers.edn"))))


(def ^{:doc "Annual measurements of the level, in feet, of Lake Huron 1875–1972."
       :format "A sequence of maps describing a time series, with `level` in feet."
       :source "Brockwell, P. J. and Davis, R. A. (1991). Time Series and Forecasting Methods. Second edition. Springer, New York. Series A, page 555./nBrockwell, P. J. and Davis, R. A. (1996). Introduction to Time Series and Forecasting. Springer, New York. Sections 5.1 and 7.6."}
  lake-huron
  (edn/read-string (slurp (io/resource "lake-huron.edn"))))


(def ^{:doc "Populations Recorded by the US Census: the population of the United States (in millions) as recorded by the decennial census for the period 1790–1970."
       :format "A sequence of maps describing a time series, with `n` in millions of people."
       :source "McNeil, D. R. (1977) Interactive Data Analysis. New York: Wiley. "}
  us-pop
  (edn/read-string (slurp (io/resource "us-pop.edn"))))



(def ^{:doc "Locations of Earthquakes off Fiji: the locations of 1000 seismic events of MB > 4.0. The events occurred in a cube near Fiji since 1964. There are two clear planes of seismic activity. One is a major plate junction; the other is the Tonga trench off New Zealand. These data constitute a subsample from a larger dataset of containing 5000 observations. From R's built-in dataset; see https://search.r-project.org/R/refmans/datasets/html/quakes.html"
       :format "A sequence of maps describing 1000 observations on 5 variables:
:lat      Latitude of event
:long     Longitude
:depth    Depth (km)
:mag      Richter Magnitude
:stations Number of stations reporting"
       :source "This is one of the Harvard PRIM-H project data sets. They in turn obtained it from Dr. John Woodhouse, Dept. of Geophysics, Harvard University. "}
  quakes
  (edn/read-string (slurp (io/resource "quakes.edn"))))


(def ^{:doc "Motor Trend Car Road Tests: data extracted from the 1974 Motor Trend US magazine, comprising fuel consumption and 10 aspects of automobile design and performance for 32 automobiles (1973–74 models). From R's built-in dataset; see https://search.r-project.org/R/refmans/datasets/html/mtcars.html"
       :format "A single map from 11 (numeric) variables to 32 observations:
mpg - Miles/(US) gallon
cyl - Number of cylinders
disp - Displacement (cu.in.)
hp - Gross horsepower
drat - Rear axle ratio
wt - Weight (1000 lbs)
qsec - 1/4 mile time
vs - Engine (0 = V-shaped, 1 = straight)
am - Transmission (0 = automatic, 1 = manual)
gear - Number of forward gears
carb - Number of carburetors

Note: Henderson and Velleman (1981) comment in a footnote to Table 1: ‘Hocking [original transcriber]'s noncrucial coding of the Mazda's rotary engine as a straight six-cylinder engine and the Porsche's flat engine as a V engine, as well as the inclusion of the diesel Mercedes 240D, have been retained to enable direct comparisons to be made with previous analyses.’"
       :source "Henderson and Velleman (1981), Building multiple regression models interactively. Biometrics, 37, 391–411."}
  mtcars
  (edn/read-string (slurp (io/resource "mtcars.edn"))))


(def ^{:doc "2009 Iranian presidential data, as reported by the Iranian government"
       :format "Seq of maps describing vote totals, by province, for each of four candidates: Mahmoud Ahmadinejad, Mir-Hossein Mousavi, Mehdi Karroubi, and Mohsen Rezaee."
       :source "University of Washington Computer Science & Engineering course materials: https://courses.cs.washington.edu/courses/cse140/13wi/homework/hw6/assignment.html"}
  iran-election-2009
  (edn/read-string (slurp (io/resource "iran-election-2009.edn"))))
