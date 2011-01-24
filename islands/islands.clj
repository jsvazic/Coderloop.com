(use 'clojure.contrib.json)
(import '(java.io InputStreamReader BufferedReader))
(import '(java.net URL URLConnection HttpURLConnection))

(defn read-content [conn]
  (with-open [is (.getContent conn)
              isr (InputStreamReader. is)
              br (BufferedReader. isr)]
    (read-json br)))

(defn open-connection [url-str]
  (let [url (URL. url-str)
        my-conn (.openConnection url)]
    (doto my-conn
      (.setRequestMethod "GET")
      (.connect))
    my-conn))

(defn get-status []
  (let [status-url "http://localhost:3000/ship/status"]
    (read-content (open-connection status-url))))

(defn move [survivor]
  (let [sail-url "http://localhost:3000/ship/sail?host="
        move-url (str sail-url survivor)
        result (read-content (open-connection move-url))]
    (if (and (:game_over result) (not (:won result)))
      (println (get-status)))))
      
(defn sail-alone []
  (let [sail-url "http://localhost:3000/ship/sail"
        result (read-content (open-connection sail-url))]
    (if (and (:game_over result) (not (:won result)))
      (println (get-status)))))
            
(move "linux")
(sail-alone)
(move "bsd")
(move "linux")
(move "windows")
(sail-alone)
(move "linux")
(let [status (get-status)]
  (if-not (:won status)
    (println status)))
