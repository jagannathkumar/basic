import reactImg from '../../assets/config.png';
import './Header.css'

const keyWord = ['Fundamental', 'Core', 'Basic'];

function getRandomVal(max) {
  return Math.floor(Math.random() * (max + 1));
}

export default function Header() {
  return (
    <header>
      <img src={reactImg} alt="Stylized atom" />
      <h1>React Essentials</h1>
      <p>
        {keyWord[getRandomVal(2)]} React concepts you will need for almost any app you are
        going to build!
      </p>
    </header>
  )
}