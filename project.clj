(defproject eloc "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://example.com/FIXME"
  :dependencies [[clojure-opennlp "0.3.3"]
                 [com.stuartsierra/component "0.3.1"]
                 [environ "1.0.2"]
                 [org.clojure/clojure "1.8.0"]
                 [prismatic/schema "1.0.5"]]
  :main eloc.main
  :min-lein-version "2.5.0"
  :repl-options {:init-ns user}
  :uberjar-name "eloc-standalone.jar"
  :profiles
  {:dev {:dependencies [[org.clojure/tools.namespace "0.2.10"]
                        [reloaded.repl "0.2.1"]]
         :source-paths ["dev"]}
   :uberjar {:aot :all
             :omit-source true}})
