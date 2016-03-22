(ns eloc.extract-test
  (:require [clojure.test :refer :all]
            [eloc.extract :refer :all]))

(deftest t-location-finder
  (let [f (make-location-finder {})]
    (are [s locs] (= locs (f s))
      "I live in the United Kingdom. In a city called London."
      ["United Kingdom" "London"]
      "Let's meet up in Cali, if you want to."
      ["Cali"]
      "Alabama, NY"
      ["Alabama"])))
