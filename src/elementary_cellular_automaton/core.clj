(ns elementary-cellular-automaton.core
  (:require [elementary-cellular-automaton.evolution :refer [generations]]
            [elementary-cellular-automaton.rendering :refer [render]]))

(defn print-evolution [rule initial-cells num-generations]
  (doseq [line (-> (generations rule initial-cells num-generations) render)]
    (println line)))
