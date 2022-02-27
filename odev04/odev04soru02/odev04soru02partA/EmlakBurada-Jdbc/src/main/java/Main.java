import com.emlakburada.dao.AdvertRepository;
import com.emlakburada.dao.UserRepository;
import com.emlakburada.entity.Advert;
import com.emlakburada.entity.User;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		System.out.println("--------USER-------------------------------------------------------------------");
		System.out.println("");
		UserRepository userRepository = new UserRepository();

		userRepository.delete(1);
		userRepository.delete(2);
		userRepository.delete(3);
		userRepository.delete(5);

		userRepository.save(prepareUser(1, "cem"));
		userRepository.save(prepareUser(2, "emir"));
		userRepository.save(prepareUser(3, "nehir"));
		userRepository.save(prepareUser(4, "melike"));
		userRepository.save(prepareUser(5, "serra"));

		System.out.println("--find all user--");

		List<User> users = userRepository.findAll();

		users.forEach(user -> System.out.println(user.toString()));

		System.out.println("--find user--");

		User foundUser = userRepository.findOne(2);

		System.out.println(foundUser.toString());

		System.out.println("--update user--");

		userRepository.updateEmail(2,"tacettinutkusuer@gmail.com");

		List<User> users2 = userRepository.findAll();

		users2.forEach(user -> System.out.println(user.toString()));

		System.out.println("--delete user--");

		userRepository.delete(4);

		List<User> users3 = userRepository.findAll();

		users3.forEach(user -> System.out.println(user.toString()));

		System.out.println("--------ADVERT-----------------------------------------------------------------");
		System.out.println("");
		AdvertRepository advertRepository = new AdvertRepository();

		advertRepository.delete(1);
		advertRepository.delete(2);
		advertRepository.delete(3);
		advertRepository.delete(5);

		advertRepository.save(prepareAdvert(1, "Acil satılık!!!"));
		advertRepository.save(prepareAdvert(2, "Kelepir fiyatına..."));
		advertRepository.save(prepareAdvert(3, "Bu hafta son..."));
		advertRepository.save(prepareAdvert(4, "Aldın, aldın!!!"));
		advertRepository.save(prepareAdvert(5, "Sahibinden satılık..."));

		System.out.println("--find all advert--");

		List<Advert> adverts = advertRepository.findAll();

		adverts.forEach(advert -> System.out.println(advert.toString()));

		System.out.println("--find advert--");

		Advert foundAdvert = advertRepository.findOne(2);

		System.out.println(foundAdvert.toString());

		System.out.println("--update advert--");

		advertRepository.updateAddress(2,"İstanbul Beşiktaş");

		List<Advert> adverts2 = advertRepository.findAll();

		adverts2.forEach(advert -> System.out.println(advert.toString()));

		System.out.println("--delete advert--");

		advertRepository.delete(4);

		List<Advert> adverts3 = advertRepository.findAll();

		adverts3.forEach(advert -> System.out.println(advert.toString()));

	}

	private static Advert prepareAdvert(int id, String title) {
		Advert advert = new Advert();
		advert.id = id;
		advert.title = title;
		advert.address = "Ankara Çankaya";
		advert.photo = "photoUrl";
		return advert;
	}

	private static User prepareUser(int id, String name) {
		User user = new User();
		user.id = id;
		user.name = name;
		user.email = "cemdrman@gmail.com";
		user.bio = "bio";
		return user;
	}

}
