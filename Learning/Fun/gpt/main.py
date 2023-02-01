from revChatGPT.Official import Chatbot
from dotenv import load_dotenv
from halo import Halo
import os

load_dotenv()

spinner = Halo(text='Asking GPT', spinner='dots')
API_KEY = os.environ.get("API_KEY")

def main():
    def get_input(prompt):
        """
        Multi-line input function
        """
        # Display the prompt
        print(prompt, end="")

        # Initialize an empty list to store the input lines
        lines = []

        # Read lines of input until the user enters an empty line
        while True:
            line = input()
            if line == "":
                break
            lines.append(line)

        # Join the lines, separated by newlines, and store the result
        user_input = "\n".join(lines)

        # Return the input
        return user_input

    def chatbot_commands(cmd: str) -> bool:
        """
        Handle chatbot commands
        """
        if cmd == "!help":
            print(
                """
            !help - Display this message
            !rollback - Rollback chat history
            !reset - Reset chat history
            !exit - Quit chat
            """
            )
        elif cmd == "!exit":
            exit()
        elif cmd == "!rollback":
            chatbot.rollback(1)
        elif cmd == "!reset":
            chatbot.reset()
        else:
            return False
        return True

    # Initialize chatbot
    chatbot = Chatbot(api_key=API_KEY)
    # Start chat
    while True:
        PROMPT = get_input("\nMags:\n")
        if PROMPT.startswith("!"):
            if chatbot_commands(PROMPT):
                continue
        spinner.start()
        response = chatbot.ask(PROMPT)
        spinner.stop()
        print("ChatGPT: " + response["choices"][0]["text"])


if __name__ == "__main__":
    main()