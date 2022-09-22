^{:nextjournal.clerk/visibility :hide-ns}
(ns notebooks.intake
  (:require #_[jsonista.core :as json]
            [applied-science.edn-datasets :as edn-datasets]
            [clojure.string :as str]
            [meta-csv.core :as mcsv]))

;;; ## `old-faithful`
(spit "resources/old-faithful.edn"
      (into [] (mcsv/read-csv "data/raw/old-faithful.csv"
                              {:fields [:eruption :waiting]})))




;;; ## `iris`
(spit "resources/iris.edn"
      (into [] (mcsv/read-csv "data/raw/iris.csv"
                              {:fields [:sepal-length :sepal-width
                                        :petal-length :petal-width
                                        :species]})))




;;; ## `anscombe`
(spit "resources/anscombe.edn"
      edn-datasets/anscombe)




;;; ## `iran-election-2009`
;; From https://courses.cs.washington.edu/courses/cse140/13wi/homework/hw6/assignment.html

;; I modified the header by hand, to avoid duplicate "%" keys.

;; It might be better to also remove commas inside quotes and then the quotes
;; _before_ mcsv, but the following (created with help from `mcsv/guess-spec`)
;; works.

(spit "resources/iran-election-2009.edn"
      (let [nix-commas #(str/replace % "," "")]
        (into [] (mcsv/read-csv "data/raw/iran-election-2009.csv"
                                {:fields [{:field :region,          :type :string}
                                          {:field :ahmadinejad,     :type :integer, :preprocess-fn nix-commas}
                                          ;; It is a HACK to use `%` in
                                          ;; keyword names, because it's
                                          ;; technically not supported by the
                                          ;; Clojure reader. But `%` makes the
                                          ;; nicest name and works on my
                                          ;; machine (tm) so until it causes a
                                          ;; problem let's leave it. -DL
                                          {:field :ahmadinejad-%,   :type :double   :preprocess-fn nix-commas}
                                          {:field :rezai,           :type :integer, :preprocess-fn nix-commas}
                                          {:field :rezai-%,         :type :double,  :preprocess-fn nix-commas}
                                          {:field :karrubi,         :type :integer, :preprocess-fn nix-commas}
                                          {:field :karrubi-%,       :type :double,  :preprocess-fn nix-commas}
                                          {:field :mousavi,         :type :integer, :preprocess-fn nix-commas}
                                          {:field :mousavi-%,       :type :double,  :preprocess-fn nix-commas}
                                          {:field :total-votes,     :type :integer, :preprocess-fn nix-commas}
                                          {:field :invalid-votes,   :type :integer, :preprocess-fn nix-commas}
                                          {:field :valid-votes,     :type :integer, :preprocess-fn nix-commas}
                                          {:field :eligible-voters, :type :integer, :preprocess-fn nix-commas}
                                          {:field :turnout-%,       :type :double,  :preprocess-fn nix-commas}]}))))


