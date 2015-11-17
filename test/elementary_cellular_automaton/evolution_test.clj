(ns elementary-cellular-automaton.evolution-test
  (:use midje.sweet)
  (:use [elementary-cellular-automaton.evolution])
  (:require [elementary-cellular-automaton.rules :as rules]))

(facts
  "An elementary cellular automaton"

  (fact
    "evolves for several generations following a given rule
    and some initial cells"
    (generations rules/rule-30 [1] 1) => [[1]]
    (generations rules/rule-30 [1] 2) => [[1] [1 1 1]]
    (generations rules/rule-30 [1] 3) => [[1] [1 1 1] [1 1 0 0 1]]
    (generations
      rules/rule-30 [1] 4) => [[1] [1 1 1] [1 1 0 0 1] [1 1 0 1 1 1 1]]))
