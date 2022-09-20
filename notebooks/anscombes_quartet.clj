^{:nextjournal.clerk/visibility {:code :hide, :result :hide}}
(ns notebooks.anscombes-quartet
  {:nextjournal.clerk/visibility {:code :fold, :result :show}}
  (:require [applied-science.edn-datasets]
            [nextjournal.clerk :as clerk]))

;; # Visualizing Anscombe's quartet

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
                                    applied-science.edn-datasets/anscombe)}
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
