(ns elementary-cellular-automaton.core
  (:require [clojure.string :as string]))

(defn- pad [cells]
  (concat [0 0] cells [0 0]))

(defn- cell-neighbors [cells]
  (partition 3 1 (pad cells)))

(defn- next-generation [cells rule]
  (map rule (cell-neighbors cells)))

(defn- spaces [num-generations generation-number]
  (let [num-spaces (- num-generations (inc generation-number))]
    (apply str (repeat num-spaces \space))))

(defn- center [num-generations generation-number line]
  (str (spaces num-generations generation-number) line))

(defn- render-zeros [line]
  (string/replace line #"0" " "))

(defn- render-ones [line]
  (string/replace line #"1" "x"))

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
       (string/join \newline)))
