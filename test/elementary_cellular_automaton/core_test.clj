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
    "produces the next generation following a given rule"
    (next-generation [1] rule-30) => [1 1 1]
    (next-generation [1 1 1] rule-30) => [1 1 0 0 1]
    (next-generation [1 1 0 0 1] rule-30) => [1 1 0 1 1 1 1])

  (fact
    "evolves for several generations following a given rule from some initial cells"
    (evolve rule-30 [1] 1) => [[1] [1 1 1]]))
