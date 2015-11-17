(ns elementary-cellular-automaton.rendering
  (:require [clojure.string :as string]
            [elementary-cellular-automaton.evolution :refer [generations]]))

(defn- spaces [num-generations generation-number]
  (let [num-spaces (- num-generations (inc generation-number))]
    (apply str (repeat num-spaces \space))))

(defn- center [num-generations generation-number line]
  (str (spaces num-generations generation-number) line))

(defn- render-zeros [line]
  (string/replace line #"0" " "))

(defn- render-ones [line]
  (string/replace line #"1" "x"))

(defn- render-generation
  [num-generations generation-number generation]
  (->> generation
       (apply str)
       (render-ones)
       (render-zeros)
       (center num-generations generation-number)))

(defn render [generations]
  (map-indexed #(render-generation (count generations) %1 %2) generations))
