(ns elementary-cellular-automaton.core-test
  (:use midje.sweet)
  (:use [elementary-cellular-automaton.core]))

(facts
  "about an elementary cellular automaton"

  (facts
    "about producing the next generation for a given rule"
    (let [rule-30 {[1 1 1] 0
                   [1 1 0] 0
                   [1 0 1] 0
                   [1 0 0] 1
                   [0 1 1] 1
                   [0 1 0] 1
                   [0 0 1] 1
                   [0 0 0] 0}]
      (next-generation [1] rule-30) => [1 1 1]
      (next-generation [1 1 1] rule-30) => [1 1 0 0 1]
      (next-generation [1 1 0 0 1] rule-30) => [1 1 0 1 1 1 1])))
