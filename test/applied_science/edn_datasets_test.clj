(ns applied-science.edn-datasets-test
  (:require [clojure.test :refer :all]
            [applied-science.edn-datasets :refer :all]))

(deftest old-faithful-test
  (testing "old faithful: sequence of maps?"
    (is (seqable? old-faithful))
    (is (every? map? old-faithful))))
