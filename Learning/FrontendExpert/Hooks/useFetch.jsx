import { useState, useEffect } from 'react';

function useFetch(url) {
  const [responseJSON, setResponseJSON] = useState(null);
  const [isLoading, setLoading] = useState(true);
  const [error, setErr] = useState(null);

  useEffect(() => {
    let cancelled = false;
    const fetchCall = async() => {
      setLoading(true);

      try {
        const response = await fetch(url);
        const res = await response.json();
        if (cancelled) return
        setResponseJSON(res);
      } catch (e) {
        if (cancelled) return
        setErr(e);
      }

      setLoading(false);
    }

    fetchCall()

    return () => (cancelled = true)
  }, [url]);

  return {
    responseJSON,
    isLoading, 
    error,
  }
}

// Do not edit the line below.
exports.useFetch = useFetch;
