(ns elementary-cellular-automaton.core
  (:require [elementary-cellular-automaton.evolution :refer [evolve]]
            [elementary-cellular-automaton.rendering :refer [render]]))

(defn print-evolution [rule initial-cells num-generations]
  (doseq [line (render (evolve rule initial-cells num-generations))]
    (println line)))
