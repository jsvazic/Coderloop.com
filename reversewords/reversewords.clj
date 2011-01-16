(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [rdr (BufferedReader. (FileReader. file-name))]
    (line-seq rdr)))

(defn reverse-words [line]
  (let [my-words (re-seq #"\w+" line) my-seps (re-seq #"\W+" line)]
    (if (nil? (re-seq #"^(\s)" line))
      (apply str (interleave (doall (map #(apply str (reverse %)) my-words)) my-seps))
	  (apply str (interleave my-seps (doall (map #(apply str (reverse %)) my-words)))))))
	
(doall (map println (map reverse-words (process-file (first *command-line-args*)))))