(import '(java.io BufferedReader FileReader))
(defn process-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
      (.trim (.readLine br))))

(def my-fact (Integer/valueOf (process-file (first *command-line-args*))))
(def my-num (str (reduce * (range 1 (inc my-fact)))))
(println (reduce + (doall (map #(reduce + %) (partition 1 1 (map #(Integer/valueOf (str %)) my-num))))))