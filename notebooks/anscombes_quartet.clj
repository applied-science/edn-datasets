^{:nextjournal.clerk/visibility {:code :hide, :result :hide}}
(ns notebooks.anscombes-quartet
  {:nextjournal.clerk/visibility {:code :fold, :result :show}}
  (:require [applied-science.edn-datasets :as edn-datasets]
            [meta-csv.core :as mcsv]
            [nextjournal.clerk :as clerk]))

;; # Visualizing Anscombe's quartet

;; https://en.m.wikipedia.org/wiki/Anscombe's_quartet

^{:nextjournal.clerk/visibility {:code :show, :result :hide}}
(defn ^:nextjournal.clerk/no-cache vl-anscombe
  "Renders (using Vega-Lite) an Anscombe dataset, as scatterplot with line of best fit."
  ([x-kw y-kw]
   (vl-anscombe x-kw y-kw [3 20] [2 13]))
  ([x-kw y-kw x-domain y-domain]
   (clerk/vl (let [encoding {:x {:field "x" :type "quantitative",
                                 :scale {:domain x-domain}
                                 :axis {:grid false, :tickCount 8}}
                             :y {:field "y" :type "quantitative",
                                 :scale {:domain y-domain}
                                 :axis {:grid false, :tickCount 5}}}]
               {:data {:values (map (comp #(hash-map :x (first %), :y (second %))
                                          (juxt x-kw y-kw))
                                    edn-datasets/anscombe)}
                :width 650, :height 400,
                :layer [{:mark {:type "line", :color "blue", :strokeWidth 1}
                         :transform [{:regression "y", :on "x"
                                      :extent x-domain}]
                         :encoding encoding}
                        {:mark {:type "point", :filled true, :color "darkorange", :size 250}
                         :encoding encoding}]}))))

(vl-anscombe :x1 :y1)
(vl-anscombe :x2 :y2)
(vl-anscombe :x3 :y3)
(vl-anscombe :x4 :y4 [3 20] [3 18])


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; # "Same Stats, Different Graphs"

;; From Justin Matejka and George Fitzmaurice's paper, _Same Stats, Different
;; Graphs: Generating Datasets with Varied Appearance and Identical Statistics
;; through Simulated Annealing"_, which in turn uses Alberto Cairo's
;; "Datasaurus":

;; > Like Anscombe's Quartet, this serves as a reminder to the importance of
;; > visualizing your data, since, although the dataset produces "normal"
;; > summary statistics, the resulting plot is a picture of a dinosaur.

;; First we must parse the TSV to EDN.

(spit "resources/datasaurus-dozen.edn"
      (into [] (mcsv/read-csv "data/raw/DatasaurusDozen.tsv")))

;; Now:

{:nextjournal.clerk/visibility {:code :show, :result :show}}
(distinct (map :dataset edn-datasets/datasaurus-dozen))

;; TODO explain pearson coefficient, calculate

;; TODO explain spearman rank correlation, calculate


(defn vl-datasaurus [ds-name values]
  (let [axis-without-ink {:axis {:grid false,
                                 :ticks false,
                                 :labels false,
                                 :title false}}]
    (clerk/vl {:width 650, :height 400
               :title ds-name
               :data {:values values}
               :mark {:type "point", :filled true}
               :encoding {:x (merge {:field "x" :type "quantitative",
                                     :scale {:domain [-10, 110]}}
                                    axis-without-ink)
                          :y (merge {:field "y" :type "quantitative",
                                     :scale {:domain [-10, 110]}}
                                    axis-without-ink)}})))


(for [[dataset-name dataset] (group-by :dataset edn-datasets/datasaurus-dozen)]
  (vl-datasaurus dataset-name dataset))
