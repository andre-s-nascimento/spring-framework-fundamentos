package br.com.andrenascimento.spring_treinamento;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

  @GetMapping("/teste")
  public String action(ModelMap model) {
    model.addAttribute("nome", "André Nascimento");
    return "teste";
  }

  @GetMapping("/teste2")
  public ModelAndView action2() {
    var modelAndView = new ModelAndView("teste");
    modelAndView.addObject("nome", "TreinaWeb2");
    return modelAndView;
  }

  @GetMapping("/teste3")
  public String action3(Model model) {
    model.addAttribute("cliente", new Cliente("André", 44));
    return "form";
  }

  @PostMapping("/teste3")
  public String action4(Cliente cliente) {
    System.out.println(cliente);
    return "form";
  }

  @GetMapping("/teste5")
  public String action5(
    @RequestParam(name = "q", required = false, defaultValue = "Andre-Nascimento") String busca,
    @RequestParam int idade,
    @RequestParam List<String> habilidades
    
    ) {
    System.out.println(busca);
    System.out.println(idade);
    System.out.println(habilidades);
    return "teste";
  }

  @GetMapping("/teste6/{id}/{name}")
  public String action6(@PathVariable("id") Long productId,
  @PathVariable("name") String productName){
    System.out.println(productId);
    System.out.println(productName);
    return "teste";
  }

}
