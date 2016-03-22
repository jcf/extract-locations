(ns eloc.extract
  (:require [clojure.java.io :as io]
            [opennlp.nlp :as nlp]))

(defn make-location-finder
  [{:keys [tokenize-model location-model]
    :or {tokenize-model "models/en-token.bin"
         location-model "models/en-ner-location.bin"}}]
  (let [tokenize (-> tokenize-model io/resource nlp/make-tokenizer)
        locs     (-> location-model io/resource nlp/make-name-finder)]
    (fn get-locations [s] (locs (tokenize s)))))

(comment
  (let [f (make-location-finder {})]
    (mapv f ["I live in the United Kingdom. In a city called London."
             "Let's meet up in Cali, if you want to."
             "Alabama, NY"]))

  ;; => [("United Kingdom" "London") ("Cali") ("Alabama")]
  )
