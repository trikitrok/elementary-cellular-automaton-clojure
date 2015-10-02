(ns elementary-cellular-automaton.core-test
  (:use midje.sweet)
  (:use [elementary-cellular-automaton.core]))

(def rule-30 {[1 1 1] 0
              [1 1 0] 0
              [1 0 1] 0
              [1 0 0] 1
              [0 1 1] 1
              [0 1 0] 1
              [0 0 1] 1
              [0 0 0] 0})

(facts
  "An elementary cellular automaton"

  (fact
    "evolves for several generations following a given rule from some initial cells"
    (evolve rule-30 [1] 1) => [[1] [1 1 1]]
    (evolve rule-30 [1] 2) => [[1] [1 1 1] [1 1 0 0 1]]
    (evolve rule-30 [1] 3) => [[1] [1 1 1] [1 1 0 0 1] [1 1 0 1 1 1 1]])

  (fact
    "can be rendered as text"
    (render rule-30 [1] 0) => "x"))
