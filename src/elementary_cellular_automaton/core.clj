(ns elementary-cellular-automaton.core
  (:require [clojure.string :as string]))

(defn- pad [cells]
  (concat [0 0] cells [0 0]))

(defn- cell-neighbors [cells]
  (partition 3 1 (pad cells)))

(defn- next-generation [cells rule]
  (map rule (cell-neighbors cells)))

(defn- center [num-generations generation-number line]
  (str (apply str (repeat (- num-generations (inc generation-number)) \space))
       line))

(defn- render-zeros [line]
  (clojure.string/replace line #"0" " "))

(defn- render-ones [line]
  (clojure.string/replace line #"1" "x"))

(defn- render-generation [num-generations generation-number generation]
  (->> generation
       (apply str)
       (render-ones)
       (render-zeros)
       (center num-generations generation-number)))

(defn evolve [rule initial-cells num-generations]
  (take num-generations (iterate #(next-generation % rule) initial-cells)))

(defn render [rule initial-cells num-generations]
  (->> (evolve rule initial-cells num-generations)
       (map-indexed #(render-generation num-generations %1 %2))
       (string/join "\n")))
