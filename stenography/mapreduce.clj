(defn parse-line [line]
    (let [tokens (.split (.toLowerCase line) " ")]
        (map #(vector % 1) tokens)))
		
(defn combine [mapped]
    (->> (group-by first mapped)
         (map (fn [[k v]]
                  {k (map second v)}))
         (apply merge-with conj)))
		 
(defn sum [[k v]]
    {k (apply + v)})

(defn reduce-parsed-lines [collected-values]
    (apply merge (map sum collected-values)))

(print (get (reduce-parsed-lines (combine (parse-line "the quick brown fox jumped over the lazy dog"))) "the"))