(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
      (.trim (.readLine br))))

(defn euler8 [my-str]
  (doall (map #(reduce * %) (partition 5 1 (map #(Long/valueOf (str %)) my-str)))))

(println (reduce max (euler8 (process-file (first *command-line-args*)))))
