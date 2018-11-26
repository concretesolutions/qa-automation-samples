
class Helper
    def validation_of_type (element , type, element_name)
        fail "parametro " + element_name + " invalido" if element.is_a?(type) == false
        puts "atributo " + element_name + " valido !"
    end  
end 