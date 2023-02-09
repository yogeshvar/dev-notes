import React, {useState} from 'react';
import './Phone.css'

export default function Phone() {
    const [telValue, setTelValue] = React.useState('')


    const handleChange = (e) => {
        setTelValue(formatTel(e.target.value))
    }

    const formatTel = (input) => {
        const rawString = input.replace(/\D/g, '')
        let output = ''

        if (rawString.length > 0) {
            output += '('
            output += rawString.substring(0, 3)
        }

        if (rawString.length > 3) {
            output += ') '
            output += rawString.substring(3,6)
        }

        if (rawString.length > 6) {
            output += '-'
            output += rawString.substring(6, 10)
        }

        return output
    }

    return (
        <div style={{ display: "flex" }}>
        <input type={'tel'} placeholder='(555) 555-5555' onChange={handleChange} value={telValue} />
        <input type={'submit'} disabled={telValue.length < 14} value="Submit" onClick={() => setTelValue('')}/>
        </div>
    );
}