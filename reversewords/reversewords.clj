(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [rdr (BufferedReader. (FileReader. file-name))]
    (line-seq rdr)))

(defn reverse-words [line]
  (let [my-words (re-seq #"\w+" line)]
    (loop [s line 
	       my-col my-words]
	  (if (empty? my-col)
	    s
		(recur (.replace s (apply str (first my-col)) (apply str (reverse (first my-col))))
		       (rest my-col))))))

(doall (map println (map reverse-words (process-file (first *command-line-args*)))))