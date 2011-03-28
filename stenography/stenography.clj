(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [rdr (BufferedReader. (FileReader. file-name))]
  (line-seq rdr)))
  
(defn get-tokens [n s]
    (let [token-sum (fn [col] (reduce #(assoc %1 %2 (inc (get %1 %2 (int 0)))) {} col))]
        (token-sum (doall (map #(apply str %) (partition n 1 s))))))

(defn find-max-token [col]
    (let [max-token (memoize (fn [t1 t2] (if (>= (get col t1) (get col t2)) t1 t2)))]
        (reduce max-token (keys col))))

(defn hex-password [s]
    (apply str (map #(apply str (cons "0x" (Integer/toHexString (int %)))) s)))
	
(defn solve [line]
    (let [a (.split (.trim line) "\\s")
	      n (Integer/valueOf (first a))
	      s (second a)]
		  (hex-password (find-max-token (get-tokens n s)))))
	
(doall (map #(println (solve %)) (process-file (first *command-line-args*))))