import React, { useEffect, useState } from "react";
import "./Main.css";

const CRYPTO_PRICES_API_BASE_URL =
  "https://api.frontendexpert.io/api/fe/cryptocurrencies";

export default function CryptoPrices() {
  const [data, setData] = useState([]);
  const [hasNext, setHasNext] = useState(true);
  const [page, setPage] = useState(0);
  useEffect(() => {
    const fetchInit = async () => {
      console.log("hello ");
      const url = new URL(CRYPTO_PRICES_API_BASE_URL);
      url.searchParams.set("page", page);
      const response = await fetch(url);
      const { coins, hasNext } = await response.json();
      setData(coins);
      setHasNext(hasNext);
    };

    fetchInit();
  }, [page]);

  return (
    <>
      <table>
        <caption>Crypto Prices</caption>
        <thead>
          <tr>
            <th scope="col">Coin</th>
            <th scope="col">Price</th>
            <th scope="col">Market Cap</th>
          </tr>
        </thead>
        <tbody>
          {data.map((coin) => (
            <tr key={coin.name}>
              <th scope="row">{coin.name}</th>
              <td>{coin.price}</td>
              <td>{coin.marketCap}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <button disabled={page === 0} onClick={() => setPage(page - 1)}>
        Back
      </button>

      <button disabled={hasNext === false} onClick={() => setPage(page + 1)}>
        Next
      </button>
    </>
  );
}
