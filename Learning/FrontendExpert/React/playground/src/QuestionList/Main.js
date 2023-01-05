import React, { useEffect, useState } from "react";
import "./Main.css";

const QUESTIONS_API_BASE_URL = "https://api.frontendexpert.io/api/fe/questions";
const SUBMISSIONS_API_BASE_URL =
  "https://api.frontendexpert.io/api/fe/submissions";

export default function QuestionList() {
  const [data, setData] = useState([]);
  useEffect(() => {
    const fetchAll = async () => {
      const questionResponse = await fetch(QUESTIONS_API_BASE_URL);
      const submissionResponse = await fetch(SUBMISSIONS_API_BASE_URL);
      const questions = await questionResponse.json();
      const submissions = await submissionResponse.json();
      // TODO: Re-visit this function later for optimization.
      questions.map((qn) => {
        const isSubmitted = submissions.find((sb) => sb.questionId === qn.id);
        if (isSubmitted === undefined) {
          qn["status"] = "unattempted";
        } else if (isSubmitted.status === "PARTIALLY_CORRECT") {
          qn["status"] = "partially-correct";
        } else {
          qn["status"] = isSubmitted.status.toLowerCase();
        }
      });
      setData(questions);
    };

    fetchAll();
  }, []);

  function categoryQns(array, category, isCount = false) {
    if (isCount) {
      const corrects = array.filter(
        (a) => a.category === category && a.status === "correct"
      );
      return corrects.length;
    }
    return array.filter((a) => a.category === category);
  }

  const categories = [...new Set(data.map((item) => item.category))];

  console.log(data);

  function renderCategory(category) {
    const qns = categoryQns(data, category);
    const corrects = categoryQns(data, category, true);
    return (
      <div className="category">
        <h2>
          {category} - {corrects}/{qns.length}
        </h2>
        {qns.map((qn) => (
          <div key={qn.id} className="question">
            <div className={`status ${qn.status}`} />
            <h3>{qn.name}</h3>
          </div>
        ))}
      </div>
    );
  }

  return (
    <>
      <div>{categories.map((category) => renderCategory(category))}</div>
    </>
  );
}
