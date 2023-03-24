import axios from "axios";
import { ChangeEvent, useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { APP_ENV } from "../../../../env";
import { ICategoryCreate } from "../types";

const CategoryCratePage = () => {

  const [model, setModel] = useState<ICategoryCreate>({
    name: "",
    description: "",
    files: [],
  });

  const onChangeHandler = (
    e:
      | ChangeEvent<HTMLInputElement>
      | ChangeEvent<HTMLTextAreaElement>
      | ChangeEvent<HTMLSelectElement>
  ) => {
    //console.log(e.target.name, e.target.value);
    setModel({ ...model, [e.target.name]: e.target.value });
  };

  const onFileHandler = (e: ChangeEvent<HTMLInputElement>) => {
    if (e.target.files) {
      const file = e.target.files[0];
      setModel({ ...model, files: [...model.files, file] });
    }
    e.target.value = "";
  }

  const contentFiles = model.files.map((f, index) => {
    return (
      <div key={index} className="mb-4">
        <img
          src={URL.createObjectURL(f)}
          className="h-auto max-w-full rounded-lg"
          alt=""
        />
      </div>
    );
  });

  const navigator = useNavigate();

  const onSubmitHandler = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      const item = await axios.post(
        `${APP_ENV.REMOTE_HOST_NAME}api/caregories`,
        model,
        {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        }
      );
      navigator("/");
    } catch (error: any) {
      console.log("Щось пішло не так", error);
    }
  };

  return (
    <div className="p-8 rounded border border-gray-200">
      <h1 className="font-medium text-3xl">Додати категорію</h1>
      <form onSubmit={onSubmitHandler}>
        <div className="mt-8 grid lg:grid-cols-1 gap-4">
          <div>
            <label
              htmlFor="name"
              className="text-sm text-gray-700 block mb-1 font-medium"
            >
              Назва
            </label>
            <input
              type="text"
              name="name"
              id="name"
              onChange={onChangeHandler}
              className="bg-gray-100 border border-gray-200 rounded py-1 px-3 block focus:ring-blue-500 focus:border-blue-500 text-gray-700 w-full"
              placeholder="Вкажіть назву категорії"
            />
          </div>

          <div>
            <label
              htmlFor="description"
              className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
            >
              Опис
            </label>
            <textarea
              id="description"
              name="description"
              rows={4}
              onChange={onChangeHandler}
              className="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              placeholder="Вкажіть опис..."
            ></textarea>
          </div>

          <div className="grid grid-cols-12 items-center gap-4">

            {contentFiles}

          </div>
          <div>
            <label className="block text-sm font-medium text-gray-700">
              Фото
            </label>

            <div className="mt-1 flex items-center">
              <label
                htmlFor="selectImage"
                className="inline-block w-20 overflow-hidden bg-gray-100"
              >

                <svg
                  className="h-full w-full text-gray-300"
                  fill="currentColor"
                  viewBox="0 0 24 24"
                >
                  <path d="M24 20.993V24H0v-2.996A14.977 14.977 0 0112.004 15c4.904 0 9.26 2.354 11.996 5.993zM16.002 8.999a4 4 0 11-8 0 4 4 0 018 0z" />
                </svg>


              </label>
              <label
                htmlFor="selectImage"
                className="ml-5 rounded-md border border-gray-300 bg-white 
          py-2 px-3 text-sm font-medium leading-4 text-gray-700 
          shadow-sm hover:bg-gray-50 focus:outline-none focus:ring-2 
          focus:ring-indigo-500 focus:ring-offset-2"
              >
                Обрати фото
              </label>
            </div>

            <input
              type="file"
              id="selectImage"
              className="hidden"
              onChange={onFileHandler}
            />
          </div>


        </div>
        <div className="space-x-4 mt-8">
          <button
            type="submit"
            className="py-2 px-4 bg-blue-500 text-white rounded hover:bg-blue-600 active:bg-blue-700 disabled:opacity-50"
          >
            Додати
          </button>
          <Link to="/" className="py-2 px-4 bg-white border border-gray-200 text-gray-600 rounded hover:bg-gray-100 active:bg-gray-200 disabled:opacity-50">
            Скасувати
          </Link>
        </div>
      </form>
    </div>
  )
}
export default CategoryCratePage;