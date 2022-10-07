import React from 'react'
import { useEffect } from 'react'
import { useState } from 'react'

export default function App() {

    //ARMAZENAR A LISTA DE PRODUTOS
    const [produtos, setProdutos] = useState([])

    useEffect(() => {

        const getProdutos = async ()=>{
            const response = await fetch("http://localhost:8080/LojaApp/rest/produto")
            const data = await response.json()

            setProdutos(data)
        }

        getProdutos()

    }, [])
    
  return (
    <div>
        <h1>CONSUMO DE API-REST</h1>
        
        <table border={1}>
            <tr>
                <th>ID</th>
                <th>TÍTULO</th>
                <th>PREÇO</th>
                <th>QUANTIDADE</th>
            </tr>

            {produtos.map((p,i)=>
                <tr key={i}>
                        <td>{p.codigo}</td>
                        <td>{p.titulo}</td>
                        <td>{p.preco}</td>
                        <td>{p.quantidade}</td>
                </tr>
            )}
        </table>

    </div>
  )
}
