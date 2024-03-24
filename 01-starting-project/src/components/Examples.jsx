import TabButton from "./TabButton.jsx";
import { EXAMPLES } from "../data";
import { useState } from "react";

export default function Examples() {
    const [selectedVal, setSelectedVal] = useState();
    
    function handleClick(selectedButton) {
        setSelectedVal(selectedButton);
    }

    let tabContent = "Please select a Topic";
    if (selectedVal) {
        tabContent = (
            <div id="tab-content">
                <h3>{EXAMPLES[selectedVal] ? EXAMPLES[selectedVal].title : ""}</h3>
                <p>{EXAMPLES[selectedVal] ? EXAMPLES[selectedVal].description : ""}</p>
                <pre>
                    <code>
                        {EXAMPLES[selectedVal] ? EXAMPLES[selectedVal].code : selectedVal}
                    </code>
                </pre>
            </div>
        )
    }
    return (
        <>
            <section id='examples'>
                <h2>Examples</h2>
                <menu>
                    <TabButton isSelected={selectedVal === 'components' ? true : false}
                        onSelect={() => handleClick('components')}>Components</TabButton>
                    <TabButton isSelected={selectedVal === 'jsx' ? true : false}
                        onSelect={() => handleClick('jsx')}>JSX</TabButton>
                    <TabButton isSelected={selectedVal === 'props' ? true : false}
                        onSelect={() => handleClick('props')}>Props</TabButton>
                    <TabButton isSelected={selectedVal === 'state' ? true : false}
                        onSelect={() => handleClick('state')}>State</TabButton>
                </menu>
            </section>
            {tabContent}
        </>
    );
}