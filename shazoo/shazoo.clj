(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [rdr (BufferedReader. (FileReader. file-name))]
  (line-seq rdr)))
  
(doall (map println (take-while #(not= "42" %) (process-file (first *command-line-args*)))))