import { CORE_CONCEPTS } from "../data";
import CoreConcept from "./CoreConcept.jsx";

export default function CoreConcepts() {
    return (<section id='core-concepts'>
        <ul>
            {/* <CoreConcept title="Components" description="Core Concepts of UI" image={compImg}></CoreConcept>
      <CoreConcept {...CORE_CONCEPTS[1]}></CoreConcept>
      <CoreConcept title={CORE_CONCEPTS[2].title} image={CORE_CONCEPTS[2].image} description={CORE_CONCEPTS[2].description}></CoreConcept>
      <CoreConcept title={CORE_CONCEPTS[3].title} image={CORE_CONCEPTS[3].image} description={CORE_CONCEPTS[3].description}></CoreConcept> */}
            {CORE_CONCEPTS.map((item) => (
                <CoreConcept key={item.title} {...item}></CoreConcept>
            ))}
        </ul>
    </section>);
}