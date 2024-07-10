import {useEffect, useState} from "react";

function Coin() {
    const [loading, setLoading] = useState(true);
    const [coins, setCoins] = useState([]);
    const [btc, setBtc] = useState(0);

    useEffect(() => {
        fetch("https://api.coinpaprika.com/v1/tickers")
            .then(res => res.json())
            .then(json => {
                setCoins(json)
                setLoading(false)
                setBtc(json[0].quotes.USD.price)
            });
    },[])

    return (

        <div>
            <h1>Coins</h1>
            {loading ? "Loading..." : null}
            <ul>
                {coins.map((coin) => (
                    <li key={coin}>
                        {(coin.quotes.USD.price/btc).toFixed(7) }BTC / {coin.symbol}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default Coin;
