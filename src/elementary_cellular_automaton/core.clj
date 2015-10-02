(ns elementary-cellular-automaton.core)

(defn- pad [cells]
  (concat [0 0] cells [0 0]))

(defn- cell-neighbors [cells]
  (partition 3 1 (pad cells)))

(defn- next-generation [cells rule]
  (map rule (cell-neighbors cells)))

(defn- pad-line [num-generations generation-number line]
  (str (apply str (repeat (- num-generations (inc generation-number)) \space))
       line))

(defn- render-generation [num-generations generation-number generation]
  (pad-line num-generations generation-number
            (clojure.string/replace
              (clojure.string/replace (apply str generation) #"1" "x")
              #"0" " ")))

(defn evolve [rule initial-cells num-generations]
  (take num-generations (iterate #(next-generation % rule) initial-cells)))

(defn render [rule initial-cells num-generations]
  (let [generations (evolve rule initial-cells num-generations)]
    (clojure.string/join
      "\n"
      (map-indexed #(render-generation num-generations %1 %2) generations))))
