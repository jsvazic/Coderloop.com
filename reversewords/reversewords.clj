(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [rdr (BufferedReader. (FileReader. file-name))]
    (line-seq rdr)))

(defn reverse-words [line]
  (let [my-words (re-seq #"\b\w+\b" line)]
    (loop [s line 
	   my-col my-words]
	  (if (empty? my-col)
	    s
	    (let [re-replace-str (apply str (list "\\b(" (first my-col) ")\\b"))]
              (recur (.replaceFirst s re-replace-str (apply str (reverse (first my-col))))
		    (rest my-col)))))))

(doall (map println (map reverse-words (process-file (first *command-line-args*)))))
