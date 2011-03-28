(def s "baababacb")

(defn get-tokens [n s]
    (let [token-sum (fn [col] (reduce #(assoc %1 %2 (inc (get %1 %2 (int 0)))) {} col))]
        (token-sum (doall (map #(apply str %) (partition n 1 s))))))

(defn find-max-token [col]
    (let [token-keys (keys col)
	      max-token (fn [t1 t2] (if (>= (get col t1) (get col t2)) t1 t2))]
        (reduce max-token token-keys)))
		
(println (find-max-token (get-tokens 3 s)))