(ns elementary-cellular-automaton.core)

(defn- pad [cells]
  (concat [0 0] cells [0 0]))

(defn- cell-neighbors [cells]
  (partition 3 1 (pad cells)))

(defn next-generation [cells rule]
  (map rule (cell-neighbors cells)))
