(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [rdr (BufferedReader. (FileReader. file-name))]
  (line-seq rdr)))
  
(defn get-tokens [n s]
    (let [tokens (doall (map #(apply str %) (partition n 1 s)))]
	    (map #(vector % 1) tokens)))
		
(defn combine [mapped]
    (->> (group-by first mapped)
         (map (fn [[k v]]
                  {k (map second v)}))
         (apply merge-with conj)))

(defn sum [[k v]]
    {k (apply + v)})

(defn reduce-map [collected-values]
    (apply merge (map sum collected-values)))

(defn hex-password [s]
    (apply str (map #(apply str (cons "0x" (Integer/toHexString (int %)))) s)))

(def max-token 
    (memoize (fn [t1 t2]
                 (if (>= (int (second t1)) (int (second t2))) t1 t2))))
	
(defn solve [line]
    (let [a (.split (.trim line) "\\s")
	      n (Integer/valueOf (first a))
	      s (second a)]
		  (hex-password (first (reduce max-token (reduce-map (combine (get-tokens n s))))))))
	
(doall (map #(println (solve %)) (process-file (first *command-line-args*))))