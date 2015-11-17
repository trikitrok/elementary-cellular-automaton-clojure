(ns elementary-cellular-automaton.rendering-test
  (:use midje.sweet)
  (:use [elementary-cellular-automaton.rendering]))

(facts
  "An elementary cellular automaton generations"

  (fact
    "can be rendered as text lines"
    (render [[1]]) => ["x"]
    (render [[1] [1 1 1]]) => [" x" "xxx"]
    (render
      [[1] [1 1 1] [1 1 0 0 1] [1 1 0 1 1 1 1]]) => ["   x" "  xxx" " xx  x" "xx xxxx"]))


